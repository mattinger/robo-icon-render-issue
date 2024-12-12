package com.inger.iconsnapshotissue

import androidx.compose.material3.Icon
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.runComposeUiTest
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.takahirom.roborazzi.RoborazziOptions
import com.github.takahirom.roborazzi.RoborazziRule
import com.github.takahirom.roborazzi.captureRoboImage
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.GraphicsMode

@RunWith(AndroidJUnit4::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
class IconSnapshotIssue {
    @get:Rule
    val roborazziRule = RoborazziRule(
        options = RoborazziRule.Options(
            roborazziOptions = RoborazziOptions(
                compareOptions = RoborazziOptions.CompareOptions(
                    changeThreshold = 0.001F
                )
            )
        )
    )


    @OptIn(ExperimentalTestApi::class)
    @Test
    fun iconIssue() {
        runComposeUiTest {
            setContent {
                Icon(
                    painter = painterResource(R.drawable.cl_ic_bluetooth_outline),
                    contentDescription = null
                )
            }
            onRoot().captureRoboImage()
        }
    }
}
