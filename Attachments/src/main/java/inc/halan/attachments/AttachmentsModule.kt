package inc.halan.attachments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import io.reactivex.rxjava3.subjects.PublishSubject

import io.reactivex.rxjava3.subjects.Subject
import java.io.File

class AttachmentsModule : Activity() {
    companion object {
        lateinit var fileType: FileType
        private val filesSubject: Subject<List<File>> = PublishSubject.create()
        private val selectedFiles: ArrayList<File> = ArrayList()
        const val ATTACHMENTS_REQUEST_CODE = 100
        lateinit var chooserTitle: String


        @JvmStatic
        fun getAttachments(
            activity: Activity,
            fileType: FileType,
            chooserTitle: String
        ): Subject<List<File>> {
            this.fileType = fileType
            this.chooserTitle = chooserTitle
            val starter = Intent(activity, AttachmentsModule::class.java)
            activity.startActivity(starter)
            return filesSubject
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getFile()
    }

    private fun getFile() {
        val selectFilesIntent = Intent(Intent.ACTION_GET_CONTENT)
        when (fileType) {
            FileType.ALL_TYPES -> selectFilesIntent.type = "*/*"
            FileType.IMAGE -> selectFilesIntent.type = "image/*"
            FileType.PDF -> selectFilesIntent.type = "application/pdf"
            FileType.WORD -> selectFilesIntent.type =
                "application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document"
            FileType.EXCEL -> selectFilesIntent.type =
                "application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"
            FileType.POWER_POINT -> selectFilesIntent.type =
                "application/vnd.ms-powerpoint,application/vnd.openxmlformats-officedocument.presentationml.presentation"
            FileType.TEXT -> selectFilesIntent.type = "text/plain"
            FileType.VIDEO -> selectFilesIntent.type = "video/*"
            FileType.AUDIO -> selectFilesIntent.type = "audio/*"
        }
        selectFilesIntent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
        startActivityForResult(
            Intent.createChooser(selectFilesIntent, chooserTitle),
            ATTACHMENTS_REQUEST_CODE
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == ATTACHMENTS_REQUEST_CODE) {
            if (resultCode == RESULT_OK && data != null) {
                val itemsCount = data.clipData?.itemCount ?: 0
                for (itemIndex in 0 until itemsCount) {
                    val item = data.clipData?.getItemAt(itemIndex)
                    selectedFiles.add(File(item?.uri?.path!!))
                }
                filesSubject.onNext(selectedFiles)
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}