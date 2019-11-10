package de.dworks.terminus.service

import de.dworks.terminus.TerminRepository
import de.dworks.terminus.model.Termin
import org.springframework.stereotype.Service

@Service
class TerminService(private val terminRepository: TerminRepository) {


    fun getAllTermine(): List<Termin> {
        val findAll: List<Termin> = terminRepository.findAll();
        return findAll;

    }

    fun addTermin(termin: Termin) {
        terminRepository.save(termin);
    }
}