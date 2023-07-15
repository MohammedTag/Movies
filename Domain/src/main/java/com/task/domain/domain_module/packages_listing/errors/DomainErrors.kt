package com.task.domain.domain_module.packages_listing.errors


sealed class DomainErrors : IllegalArgumentException() {
    class BackendError(val status: Int, override val message: String) : DomainErrors()
    class NullInput : DomainErrors()
}