package de.dworks.terminus.service

import de.dworks.terminus.TerminRepository
import de.dworks.terminus.model.Termin
import org.springframework.stereotype.Service
import org.thymeleaf.util.DateUtils
import java.util.*


@Service
class IcsService(private val terminRepository: TerminRepository) {

    private val ICS_TEMPLATE = "icsTemplate.txt"
    private val TITLE = "%TITLE%"
    private val TIMESTAMP = "%TIMESTAMP"
    private val STARTDATE = "%STARTDATE%"
    private val ENDDATE = "%ENDDATE%"

    fun returnAIcs(id: String): String {
        val first = terminRepository.findAll().stream().filter { pred -> pred.id.equals(id) }.findFirst();
        var template = readTextTemplate();
        if (first.isPresent) {
            template = replaceMarkers(first, template)
        }

        return template;
    }


    private fun replaceMarkers(first: Optional<Termin>, template: String): String {
        var returnTemplate = template
        val entry = first.get()
        returnTemplate = returnTemplate.replace(TITLE, entry.name);
        returnTemplate = returnTemplate.replace(TIMESTAMP, mapToDateString(DateUtils.createNow().time))
        returnTemplate = returnTemplate.replace(STARTDATE, mapToDateString(entry.startDate))
        returnTemplate = returnTemplate.replace(ENDDATE, mapToDateString(entry.endDate))
        return returnTemplate
    }

    fun mapToDateString(date: Date): String {
        var calendar = Calendar.getInstance();
        calendar.setTime(date)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val month = calendar.get(Calendar.MONTH)
        val year = calendar.get(Calendar.YEAR)
        val hour = calendar.get(Calendar.HOUR)
        val minute = calendar.get(Calendar.MINUTE)
        val second = calendar.get(Calendar.SECOND)
        return year.toString()+month.toString()+day.toString()+"T"+hour.toString()+minute.toString()+second.toString();
    }


    fun readTextTemplate(): String {
        return this::class.java.classLoader.getResource(ICS_TEMPLATE).readText();
    }
}