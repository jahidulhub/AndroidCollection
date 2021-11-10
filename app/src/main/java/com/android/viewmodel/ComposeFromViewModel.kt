package com.android.viewmodel

import android.app.Application
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel

/***
 * implementing to MainActivity
 * class MainActivity: ComponentActivity() {
 *      private val viewModel by viewModels<SampleViewModel>()
 *      override fun onCreate() {
 *          ...
 *          setContent {
 *              ComposeViewModel(viewModel)
 *          }
 *      }
 */
@Composable
fun ComposeFromViewModel() {
    val context = LocalContext.current
    val model : SampleViewModel = viewModel(
        factory = SampleViewModelFactory(
            context.applicationContext as Application
        )
    )
    Column {
        val status = model.status.value
        if (status != null) {
            Text(status)
        }
        val item = "sample String as item"
        val list = model.list
        Text(list[0]) // get first index of the list
        Button(
            onClick = {
                model.addItem(item)
            }
        ) {
            Text("Add Item")
        }
    }
}