package ru.ptsecurity.navigation_example.ui.view

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.util.AttributeSet
import android.view.View
import android.view.View.OnClickListener
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.isInvisible
import ru.ptsecurity.navigation_example.R
import ru.ptsecurity.navigation_example.databinding.ViewPasscodeBinding


class PasscodeView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    companion object {
        private const val MAX_PASSCODE_LENGTH = 4
    }

    private val binding = ViewPasscodeBinding.bind(
        inflate(context, R.layout.view_passcode, this)
    )

    private val digitsClickListener = OnClickListener {
        addPasscodeNumber((it as TextView).text)
    }
    private val additionalClickListener = OnClickListener {
        removePasscodeNumber()
    }

    private var onChangePasscodeListener: OnChangePasscodeListener? = null
    private val pinViews: List<View>
    private var passcode: String = ""
    private val isInputCompleted: Boolean get() = (passcode.length == MAX_PASSCODE_LENGTH)
    private val primaryColor by lazy { ContextCompat.getColor(context, R.color.dark_color) }
    private val secondaryColor by lazy { ContextCompat.getColor(context, R.color.light_color) }

    init {
        with(binding) {
            oneTv.setOnClickListener(digitsClickListener)
            twoTv.setOnClickListener(digitsClickListener)
            threeTv.setOnClickListener(digitsClickListener)
            fourTv.setOnClickListener(digitsClickListener)
            fiveTv.setOnClickListener(digitsClickListener)
            sixTv.setOnClickListener(digitsClickListener)
            sevenTv.setOnClickListener(digitsClickListener)
            eightTv.setOnClickListener(digitsClickListener)
            nineTv.setOnClickListener(digitsClickListener)
            zeroTv.setOnClickListener(digitsClickListener)

            additionalActionIv.setOnClickListener(additionalClickListener)

            pinViews = listOf(pinOneView, pinTwoView, pinThreeView, pinFourView)
        }
    }

    private fun addPasscodeNumber(number: CharSequence) {
        if (isInputCompleted) return

        setPinStatus(passcode.length, true)
        passcode += number

        updateAdditionalIcon()
        onChangePasscodeListener?.onChangePasscode(
            passcode = passcode,
            isCompleted = isInputCompleted,
            isDeleting = false
        )
    }

    private fun removePasscodeNumber() {
        setPinStatus(passcode.lastIndex, false)

        if (passcode.isEmpty()) return

        passcode = passcode.dropLast(1)
        updateAdditionalIcon()
        onChangePasscodeListener?.onChangePasscode(
            passcode = passcode,
            isCompleted = false,
            isDeleting = true
        )
    }

    private fun setPinStatus(position: Int, isEnabled: Boolean) {
        pinViews.getOrNull(position)?.apply {
            backgroundTintMode = PorterDuff.Mode.MULTIPLY
            backgroundTintList = ColorStateList.valueOf(
                if (isEnabled) primaryColor else secondaryColor
            )
        }
    }

    private fun updateAdditionalIcon() = with(binding) {
        additionalActionIv.isInvisible = false

        when {
            passcode.isNotEmpty() ->
                additionalActionIv.setImageResource(R.drawable.ic_backspace)
            else -> additionalActionIv.isInvisible = true
        }
    }

    fun setOnChangePasscodeListener(listener: OnChangePasscodeListener?) {
        this.onChangePasscodeListener = listener
    }

    fun interface OnChangePasscodeListener {
        fun onChangePasscode(passcode: String, isCompleted: Boolean, isDeleting: Boolean)
    }
}