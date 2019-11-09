package de.dworks.terminus.model

import org.junit.jupiter.api.Test
import java.time.Instant
import java.util.*

class TerminTest {

    @Test
    fun initTermin() {
        val termin = Termin(1, "name", "descr", Date.from(Instant.now()), Date.from(Instant.now())
        )
        assert(!termin.startDate.equals(null))
    }
}