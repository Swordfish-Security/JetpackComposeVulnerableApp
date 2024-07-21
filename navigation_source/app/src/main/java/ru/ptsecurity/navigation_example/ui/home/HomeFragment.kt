package ru.ptsecurity.navigation_example.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.ptsecurity.navigation_example.R
import ru.ptsecurity.navigation_example.databinding.FragmentHomeBinding

open class HomeFragment : Fragment() {

    companion object {
        const val URL_ARG_KEY = "url"
        const val DATA_ARG_KEY = "data"
        const val INFO_ARG_KEY = "info"
        const val USERNAME_ARG_KEY = "name"
        const val USER_SURNAME_ARG_KEY = "surname"
        const val HARDCODE_URL = "https://evil.com/"
        const val HARDCODE_USER_NAME = "Johnny"
        const val HARDCODE_USER_SURNAME = "Blaze"
        const val HARDCODE_INFO = "My Info"
        const val HARDCODE_INNER_INFO = "My Inner Info"
        const val HARDCODE_IMAGE = "https://gratisography.com/wp-content/uploads/2023/01/gratisography-frog-racer-free-stock-photo-1165x780.jpg"
    }

    private val binding by viewBinding(FragmentHomeBinding::bind)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home,null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.openWvBtn.setOnClickListener {
            val args = Bundle()
            args.putString(URL_ARG_KEY, HARDCODE_URL)

            findNavController().navigate(R.id.navigation_webview, args)
        }

        binding.writeDataBtn.setOnClickListener {
            val args = Bundle()
            args.putString(DATA_ARG_KEY, HARDCODE_URL)

            findNavController().navigate(R.id.navigation_write_to_file, args)
        }

        binding.saveToDbBtn.setOnClickListener {
            val args = Bundle()
            args.putString(USERNAME_ARG_KEY, HARDCODE_USER_NAME)
            args.putString(USER_SURNAME_ARG_KEY, HARDCODE_USER_SURNAME)

            findNavController().navigate(R.id.navigation_save_to_db, args)
        }

        binding.intentWithUrlBtn.setOnClickListener {
            val args = Bundle()
            args.putString(USERNAME_ARG_KEY, HARDCODE_IMAGE)

            findNavController().navigate(R.id.navigation_intent_with_url, args)
        }

        binding.showInfoBtn.setOnClickListener {
            val args = Bundle()
            args.putString(INFO_ARG_KEY, HARDCODE_INFO)

            findNavController().navigate(R.id.navigation_show_info, args)
        }

        binding.showInnerBtn.setOnClickListener {
            val args = Bundle()
            args.putString(INFO_ARG_KEY, HARDCODE_INNER_INFO)

            findNavController().navigate(R.id.toInner, args)
        }
    }
}