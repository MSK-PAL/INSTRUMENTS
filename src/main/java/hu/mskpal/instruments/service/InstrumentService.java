package hu.mskpal.instruments.service;

import hu.mskpal.instruments.model.Instrument;
import hu.mskpal.instruments.repository.InstrumentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstrumentService {

    private final InstrumentRepository repo;

    public InstrumentService(InstrumentRepository repo) {
        this.repo = repo;
    }

    public List<Instrument> findAll() {
        return repo.findAll();
    }

    public Instrument save(Instrument instrument) {
        return repo.save(instrument);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Instrument findById(Long id) {
        return repo.findById(id).orElse(null);
    }
}