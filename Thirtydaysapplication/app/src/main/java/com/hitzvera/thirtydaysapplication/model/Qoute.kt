package com.hitzvera.thirtydaysapplication.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Qoute(
    @StringRes val qoute: Int,
    @StringRes val qouteDes: Int,
    @DrawableRes val qouteImg: Int,
)