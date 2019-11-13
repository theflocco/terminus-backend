package de.dworks.terminus.model;

import java.util.*

data class TerminDTO(
        val id: String?,

        val name: String,

        val description: String,

        val startDate: DateDTO,

        val endDate: DateDTO
)