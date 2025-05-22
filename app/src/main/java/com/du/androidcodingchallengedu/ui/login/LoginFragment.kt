package com.du.androidcodingchallengedu.ui.login

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.du.androidcodingchallengedu.R
import com.du.androidcodingchallengedu.databinding.LayoutLoginBinding
import java.util.regex.Matcher
import java.util.regex.Pattern


class LoginFragment: Fragment() {
    private lateinit var binding: LayoutLoginBinding

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.layout_login,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        setUpOnClick()

    }

    private fun setUpOnClick() {
        binding.editTextEmailId.addTextChangedListener {
            object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    TODO("Not yet implemented")
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    TODO("Not yet implemented")
                }

                override fun afterTextChanged(p0: Editable?) {
                    val pattern: Pattern
                    val matcher: Matcher
                    val EMAIL_PATTERN =
                        "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
                    pattern = Pattern.compile(EMAIL_PATTERN)
                    val cs = p0 as CharSequence
                    matcher = pattern.matcher(cs)
                    if (matcher.matches() != true) {
                        binding.editTextEmailId.error = "Invalid email"
                    }
                }

            }
        }

        binding.editTextPassword.addTextChangedListener {
            object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    TODO("Not yet implemented")
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    TODO("Not yet implemented")
                }

                override fun afterTextChanged(p0: Editable?) {
                    val pattern: Pattern
                    val matcher: Matcher
                    val PASSWORD_PATTERN =
                        "^(?=.*[A-Za-z])(?=.*\\\\d)(?=.*[$@$!%*#?&])[A-Za-z\\\\d$@$!%*#?&]{8,15}$"
                    pattern = Pattern.compile(PASSWORD_PATTERN)
                    val cs = p0 as CharSequence
                    matcher = pattern.matcher(cs)
                    if (!matcher.matches()) {
                        binding.editTextPassword.error = "Invalid password"
                    }
                }
            }
        }

        binding.authenticate.setOnClickListener {

            if (binding.editTextEmailId.error.isNotEmpty() || binding.editTextEmailId.text.isNullOrEmpty()) {
                binding.editTextEmailId.error = "Enter valid email id"
            } else if (binding.editTextPassword.error.isNotEmpty() || binding.editTextPassword.text.isNullOrEmpty()) {
                binding.editTextPassword.error = "Enter valid password"
            } else {
                findNavController().navigate(R.id.action_first_to_second)
            }
        }
    }
}