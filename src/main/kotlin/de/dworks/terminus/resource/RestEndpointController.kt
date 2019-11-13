package de.dworks.terminus.resource

import de.dworks.terminus.model.Termin
import de.dworks.terminus.model.TerminDTO
import de.dworks.terminus.service.IcsService
import de.dworks.terminus.service.TerminService
import org.springframework.web.bind.annotation.*
import java.time.Instant
import java.util.*

@CrossOrigin(origins = ["http://localhost:4200"])
@RestController
class RestEndpointController(private val terminService: TerminService,
                             private val icsService: IcsService) {

    @RequestMapping("/all")
    fun getAll(): List<Termin> {
        val allTermine = terminService.getAllTermine()
        print("return list of termine: " + allTermine.size)
        return allTermine
    }

    @PostMapping("/add")
    fun addTermin(@RequestBody terminDTO: TerminDTO) {
        val termin = mapToTermin(terminDTO)
        print("adding termin" + termin)
        val savedTermin = terminService.addTermin(termin)
        val icsData = icsService.returnAIcs(savedTermin.id)
    }

    private fun mapToTermin(terminDTO: TerminDTO): Termin {
        val startDateCal = Calendar.getInstance();
        startDateCal.set(terminDTO.startDate.year, terminDTO.startDate.month, terminDTO.startDate.day)

        val endDateCal = Calendar.getInstance();
        endDateCal.set(terminDTO.endDate.year, terminDTO.endDate.month, terminDTO.endDate.day)

        return Termin(terminDTO.id.orEmpty(), terminDTO.name, terminDTO.description, startDateCal.time, endDateCal.time)
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