package de.dworks.terminus.model

import java.util.*
import javax.persistence.*

@Entity
data class Termin(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int,

        val name: String,

        val description: String,

        val startDate: Date,

        val endDate: Date
)