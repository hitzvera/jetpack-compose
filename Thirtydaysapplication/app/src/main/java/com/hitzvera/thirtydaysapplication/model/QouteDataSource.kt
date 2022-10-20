package com.hitzvera.thirtydaysapplication.model

import androidx.compose.ui.res.stringResource
import com.hitzvera.thirtydaysapplication.R

object QouteDataSource {
    val qoutes: List<Qoute> = listOf(
        Qoute(
            qoute = R.string.qoute_1,
            qouteDes = R.string.desc_1,
            qouteImg = R.drawable.photo_1
        ),
        Qoute(
            qoute = R.string.qoute_2,
            qouteDes = R.string.desc_2,
            qouteImg = R.drawable.photo_2
        ),
        Qoute(
            qoute = R.string.qoute_3,
            qouteDes = R.string.desc_3,
            qouteImg = R.drawable.photo_3
        ),
    )
}