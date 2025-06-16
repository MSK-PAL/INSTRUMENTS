package hu.mskpal.instruments.service;

import hu.mskpal.instruments.model.Instrument;
import hu.mskpal.instruments.repository.InstrumentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class InstrumentServiceTest {

    private InstrumentRepository repo;
    private InstrumentService service;

    @BeforeEach
    void setup() {
        repo = mock(InstrumentRepository.class);
        service = new InstrumentService(repo);
    }

    @Test
    void testFindAll() {
        List<Instrument> list = List.of(new Instrument(), new Instrument());
        when(repo.findAll()).thenReturn(list);
        assertEquals(2, service.findAll().size());
    }

    @Test
    void testSave() {
        Instrument instrument = new Instrument();
        instrument.setName("Violin");
        when(repo.save(instrument)).thenReturn(instrument);
        assertEquals("Violin", service.save(instrument).getName());
    }

    @Test
    void testDelete() {
        service.delete(42L);
        verify(repo, times(1)).deleteById(42L);
    }

    @Test
    void testFindById_found() {
        Instrument i = new Instrument();
        i.setId(7L);
        when(repo.findById(7L)).thenReturn(Optional.of(i));
        assertEquals(7L, service.findById(7L).getId());
    }

    @Test
    void testFindById_notFound() {
        when(repo.findById(100L)).thenReturn(Optional.empty());
        assertNull(service.findById(100L));
    }
}
