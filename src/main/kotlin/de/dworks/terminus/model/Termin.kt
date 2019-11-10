package de.dworks.terminus.model

import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*

@Entity
data class Termin(

        @Id
        @GeneratedValue(generator = "uuid")
        @GenericGenerator(name = "uuid", strategy = "uuid2")
        val id: String,

        val name: String,

        val description: String,

        val startDate: Date,

        val endDate: Date
)