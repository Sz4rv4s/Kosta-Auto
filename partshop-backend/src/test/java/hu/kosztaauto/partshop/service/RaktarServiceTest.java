package hu.kosztaauto.partshop.service;

import hu.kosztaauto.partshop.dto.RaktarDTO;
import hu.kosztaauto.partshop.model.Raktar;
import hu.kosztaauto.partshop.repository.RaktarRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class RaktarServiceTest {

    @InjectMocks
    private RaktarService raktarService;

    @Mock
    private RaktarRepository raktarRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks( this );
    }

    @Test
    public void testConvertToRaktarDTOShouldReturnRaktarDTO() {
        //given
        Raktar raktar = new Raktar(
                1L,"nev","varos","cim",15
        );

        //when
        RaktarDTO raktarDTO = raktarService.convertToRaktarDTO(raktar);

        //then
        Assertions.assertEquals(raktarDTO.getId(), raktar.getId());
        Assertions.assertEquals(raktarDTO.getNev(), raktar.getNev());
        Assertions.assertEquals(raktarDTO.getVaros(), raktar.getVaros());
        Assertions.assertEquals(raktarDTO.getCim(), raktar.getCim());
        Assertions.assertEquals(raktarDTO.getKapacitas(), raktar.getKapacitas());
    }
}
