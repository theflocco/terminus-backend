package de.dworks.terminus.resource

import de.dworks.terminus.model.Termin
import org.springframework.stereotype.Controller
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.Instant
import java.util.*

@RestController
class RestEndpointController {

    @RequestMapping("/termine")
    fun getTermin(): Termin {
        var termin = Termin(id = 1, name = "hi", description = "descr", startDate = Date.from(Instant.now()), endDate = Date.from(Instant.now()))
        return termin
    }

    @RequestMapping("/hi")
    fun getHi(): String {
        return "Hi"
    }

}