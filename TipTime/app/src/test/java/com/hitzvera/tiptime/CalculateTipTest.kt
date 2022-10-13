package com.hitzvera.tiptime

import junit.framework.Assert.assertEquals
import org.junit.Test


class CalculateTipTest {

    @Test
    fun calculate_20_percent_tip_no_round_up(){
        val amount = 10.00
        val tipPercent = 20.00
        val expectedTip = "IDR2.00"
        val actualTip = calculateTip(amount = amount, false, tipPercent)
        assertEquals(expectedTip, actualTip)
    }


}