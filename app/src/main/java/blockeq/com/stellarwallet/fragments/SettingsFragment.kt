package blockeq.com.stellarwallet.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import blockeq.com.stellarwallet.R
import blockeq.com.stellarwallet.WalletApplication
import blockeq.com.stellarwallet.models.PinType
import kotlinx.android.synthetic.main.fragment_settings.*


class SettingsFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_settings, container, false)

    companion object {
        fun newInstance(): SettingsFragment = SettingsFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI()
    }

    //region User Interface

    private fun setupUI() {
        viewPhraseButton.setOnClickListener {
            val phrase = WalletApplication.localStore!!.encryptedPhrase!!
            launchPINView(PinType.VIEW_PHRASE, "", phrase, false)
        }

        viewSeedButton.setOnClickListener {
            val phrase = WalletApplication.localStore!!.encryptedPhrase!!
            launchPINView(PinType.VIEW_SEED, "", phrase, false)
        }

        clearWalletButton.setOnClickListener {
            val phrase = WalletApplication.localStore!!.encryptedPhrase!!
            launchPINView(PinType.CLEAR_WALLET, "", phrase, false)
        }
    }

}
