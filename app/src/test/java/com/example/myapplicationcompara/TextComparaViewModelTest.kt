package com.example.myapplicationcompara

import model.TextComparar
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import viewmodel.viewmodel.TextComparaViewModel
import org.junit.Assert.assertEquals


class TextComparaViewModelTest {

    private lateinit var viewModel: TextComparaViewModel

    @Before
    fun setup() {
        viewModel = TextComparaViewModel()
    }

    @Test
    fun testTextComparadoIguales() {
        val textIguales = TextComparar("Pocho", "Pocho")
        val result = viewModel.compareTexts(textIguales)
        Assert.assertTrue(result)
    }

    @Test
    fun testTextComparadoDifer() {
        val textDiferentes = TextComparar("Pocho", "OtroPocho")
        val result = viewModel.compareTexts(textDiferentes)
        Assert.assertFalse(result)
    }


}
