package com.task.task.ui_module.utils

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import androidx.navigation.fragment.findNavController
import com.task.task.R

/**
 * This class solves th navigation IllegalArgumentException that is almost produced by double clicking
 * while navigating.
 *
 * For more info  :
 * @see <a href="https://medium.com/@ffvanderlaan/fixing-the-dreaded-is-unknown-to-this-navcontroller-68c4003824ce></a>
 */

private const val TAG = "FragmentNavExtensions"

/**
 * Navigates only if this is safely possible; when this Fragment is still the current destination.
 */
fun Fragment.navigateSafe(
    @IdRes resId: Int,
    args: Bundle? = null,
    navOptions: NavOptions? = null,
    navigatorExtras: Navigator.Extras? = null
) {
    if (canNavigate()) findNavController().navigate(
        resId, args,
        navOptions, navigatorExtras
    )
}

/**
 * Navigates only if this is safely possible; when this Fragment is still the current destination.
 */
fun Fragment.navigateSafe(
    deepLink: Uri,
    navOptions: NavOptions? = null,
    navigatorExtras: Navigator.Extras? = null
) {
    if (canNavigate()) findNavController().navigate(deepLink, navOptions, navigatorExtras)
}

/**
 * Navigates only if this is safely possible; when this Fragment is still the current destination.
 */
fun Fragment.navigateSafe(directions: NavDirections, navOptions: NavOptions? = null) {
    if (canNavigate()) findNavController().navigate(directions, navOptions)
}

/**
 * Navigates only if this is safely possible; when this Fragment is still the current destination.
 */
fun Fragment.navigateSafe(
    directions: NavDirections,
    navigatorExtras: Navigator.Extras
) {
    if (canNavigate()) findNavController().navigate(directions, navigatorExtras)
}

/**
 * Returns true if the navigation controller is still pointing at 'this' fragment, or false if it already navigated away.
 */
private fun Fragment.canNavigate(): Boolean {

    val navController = findNavController()
    val destinationIdInNavController = navController.currentDestination?.id

    // add tag_navigation_destination_id to your ids.xml so that it's unique:
    val destinationIdOfThisFragment =
        view?.getTag(R.id.tag_navigation_destination_id) ?: destinationIdInNavController

    // check that the navigation graph is still in 'this' fragment, if not then the app already navigated:
    return if (destinationIdInNavController == destinationIdOfThisFragment) {
        view?.setTag(R.id.tag_navigation_destination_id, destinationIdOfThisFragment)
        true
    } else {
        Log.v(
            TAG,
            "May not navigate: current destination is not the current fragment."
        )
        false
    }
}