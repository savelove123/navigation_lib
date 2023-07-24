package com.felix.android.navigation

import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.getParams
import androidx.lifecycle.setParams
import androidx.lifecycle.viewModelScope
import com.felix.android.navigation.destination.NavDestination
import com.felix.android.navigation.ext.MutableLiveEvent
import com.felix.android.navigation.model.NavigationCommand
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow

/**
 * 支持导航的ViewModel
 */
abstract class NavViewModel<T: NavDestination>(application: Application): AndroidViewModel(application),
    NavComponent<T> {

    override val navigableScope: CoroutineScope = viewModelScope
    override val router: MutableLiveEvent<NavigationCommand> = MutableLiveEvent()

    override var activityResultLauncher: ActivityResultLauncher<Intent>?=null
    override var resultFlow: MutableSharedFlow<ActivityResult>? = null

    fun <T: Parcelable> Parameterized<T>.requireVMParams():T{
        return getParams()
    }

    fun <T:Parcelable> Parameterized<T>.injectVMParams( params:T? ){
        setParams( params )
    }

    abstract fun attachViewModel(savedInstanceState: Bundle?)

}