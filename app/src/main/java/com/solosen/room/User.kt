package com.solosen.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(@PrimaryKey val rowId: Int = 0, val username: String, val password: String)