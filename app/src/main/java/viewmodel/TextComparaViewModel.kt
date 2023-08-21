package viewmodel.viewmodel

import androidx.lifecycle.ViewModel
import model.TextComparar

class TextComparaViewModel : ViewModel() {

    fun compareTexts(textComparison: TextComparar): Boolean {
        return textComparison.firstText.trim() == textComparison.secondText.trim()
    }
}
