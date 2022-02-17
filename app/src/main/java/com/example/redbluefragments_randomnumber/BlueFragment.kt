package com.example.redbluefragments_randomnumber

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider


/**
 * A simple [Fragment] subclass.
 * Use the [BlueFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
const val RANDOM_NUMBER_VIEWED = "package com.example.redbluefragments_randomnumber.BlueFragment.RandViewed"
class BlueFragment : Fragment() {

    private lateinit var randomNumberTextView: TextView

    private val randomNumberViewModel: RandomNumberViewModel by lazy {
        ViewModelProvider(requireActivity()).get(RandomNumberViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_blue, container, false)
        randomNumberTextView = view.findViewById(R.id.random_number_text_view)

//        showRandomNumber()
        randomNumberViewModel.randomNumber.observe(requireActivity()) {
            // The new value -> task to do with the new value
            random -> showRandomNumber(random)
        }
        randomNumberTextView.setOnClickListener {
            parentFragmentManager.setFragmentResult(RANDOM_NUMBER_VIEWED, Bundle.EMPTY)
        }
        return view
    }

    private fun showRandomNumber(randomNumber: Int) {
        randomNumberTextView.text = randomNumber.toString()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         */

        @JvmStatic
        fun newInstance() = BlueFragment()
    }
}