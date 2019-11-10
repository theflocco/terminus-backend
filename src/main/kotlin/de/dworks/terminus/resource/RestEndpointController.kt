package de.dworks.terminus.resource

import de.dworks.terminus.model.Termin
import de.dworks.terminus.service.TerminService
import org.springframework.web.bind.annotation.*
import java.time.Instant
import java.util.*

@RestController
class RestEndpointController(private val terminService: TerminService) {

    @RequestMapping("/all")
    fun getAll(): List<Termin> {
        return terminService.getAllTermine();
    }

    @PostMapping("/add")
    fun addTermin(@RequestBody termin: Termin) {
        print("add called")
        terminService.addTermin(termin)
    }

    @RequestMapping("/hi")
    fun getHi(): String {
        return "Hi"
    }


    @GetMapping("/termin")
    fun getTermin(): Termin {
        var termin = Termin(id = 1, name = "hi", description = "descr", startDate = Date.from(Instant.now()), endDate = Date.from(Instant.now()))
        return termin
    }




}