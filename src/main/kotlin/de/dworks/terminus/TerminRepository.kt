package de.dworks.terminus

import de.dworks.terminus.model.Termin
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface TerminRepository: JpaRepository<Termin, Long>{
}