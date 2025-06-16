package hu.mskpal.instruments.repository;

import hu.mskpal.instruments.model.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstrumentRepository extends JpaRepository<Instrument, Long> {
}