package com.example.redbluefragments_randomnumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // What size is the screen?
        // If smaller less than 600 DP, then use listener and swap fragments.
        // Otherwise nothing else is needed.

        val deviceSmallestWidth = resources.configuration.smallestScreenWidthDp

        if (deviceSmallestWidth < 600) {
            supportFragmentManager.setFragmentResultListener(
                RANDOM_NUMBER_GEN,
                this
            ) { requestKey, bundle -> // Swap out red fragment for blue fragment
                supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, BlueFragment.newInstance())
                    .addToBackStack("BLUE")
                    .commit()
            }

            supportFragmentManager.setFragmentResultListener(
                RANDOM_NUMBER_VIEWED,
                this
            ) { requestKey, bundle -> // Swap out blue fragment for red fragment
                supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, RedFragment.newInstance())
                    .addToBackStack("RED")
                    .commit()
            }
        }
        // Options: 1. Adds, 2. Replaces.
        // 1. Pause the red fragment, add the blue fragment "on top" <- Fine for lightweight fragments
        // 2. Replace the red fragment with the blue fragment <- red fragment is destroyed.
    }
}