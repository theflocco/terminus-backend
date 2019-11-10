package de.dworks.terminus.resource

import de.dworks.terminus.model.Termin
import de.dworks.terminus.service.TerminService
import org.springframework.web.bind.annotation.*
import java.time.Instant
import java.util.*

@RestController
class RestEndpointController(private val terminService: TerminService) {

    @CrossOrigin
    @RequestMapping("/all")
    fun getAll(): List<Termin> {
        val allTermine = terminService.getAllTermine()
        print("return list of termine: " + allTermine.size)
        return allTermine
    }

    @PostMapping("/add")
    fun addTermin(@RequestBody termin: Termin) {
        print("adding termin" + termin)
        terminService.addTermin(termin)
    }

    @GetMapping("/id/{id}")
    fun getTerminById(@PathVariable id: String): Termin {
        val terminById = terminService.findTerminById(id);
        return terminById.get(0);
    }

    @RequestMapping("/hi")
    fun getHi(): String {
        return "Hi"
    }


    @GetMapping("/termin")
    fun getTermin(): Termin {
        var termin = Termin(id = "1", name = "hi", description = "descr", startDate = Date.from(Instant.now()), endDate = Date.from(Instant.now()))
        return termin
    }




}