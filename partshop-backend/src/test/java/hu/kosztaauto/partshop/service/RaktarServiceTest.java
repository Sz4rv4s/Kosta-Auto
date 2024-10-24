package hu.kosztaauto.partshop.service;

import hu.kosztaauto.partshop.dto.RaktarDTO;
import hu.kosztaauto.partshop.dto.RaktarWithItemsDTO;
import hu.kosztaauto.partshop.model.Alkatresz;
import hu.kosztaauto.partshop.model.Raktar;
import hu.kosztaauto.partshop.repository.RaktarRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

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
    public void testGetAllWarehousesShouldReturnAllWarehousese() {
        //given
        Raktar r1 = new Raktar(
                1L,"nev","varos","cim",15
        );

        Raktar r2 = new Raktar(
                2L,"neve","varosa","cime",17
        );

        Raktar r3 = new Raktar(
                3L,"ne","varo","ci",19
        );

        List<Raktar> raktarList = List.of(r1, r2, r3);
        Mockito.when( raktarRepository.findAll() ).thenReturn(raktarList);

        //when
        List<RaktarDTO> list = raktarService.getAllWarehouses();

        //then
        Assertions.assertEquals( raktarList.size(), list.size() );
    }

    @Test
    public void testGetAllItemsByWarehouseShouldReturnAllItemsByWarehouse() {
        //given
        Raktar r1 = new Raktar(
                1L,"nev","varos","cim",15, List.of(
                        new Alkatresz("cikkszam","megnevezes","tipus",1500)
        )
        );

        Raktar r2 = new Raktar(
                2L,"neve","varosa","cime",19, List.of(
                new Alkatresz("cikkszama","megnevezese","tipusa",1590)
        )
        );

        List<Raktar> raktarList = List.of(r1, r2);
        Mockito.when( raktarRepository.findAll() ).thenReturn(raktarList);

        //when
        List<RaktarWithItemsDTO> lista = raktarService.getAllItemsByWarehouse();

        //then
        Assertions.assertEquals( raktarList.size(), lista.size() );
    }

    @Test
    public void testGetItemsByWarehouseNameShouldReturnItemsByWarehouseName() {
        //given
        String name = "nev";
        Raktar raktar = new Raktar(
                1L,"nev","varos","cim",15, List.of(
                new Alkatresz("cikkszam","megnevezes","tipus",1500)
        )
        );
        Mockito.when(raktarRepository.findByNevContainingIgnoreCase( name ) ).thenReturn(List.of(raktar));

        //when
        List<RaktarWithItemsDTO> lista = raktarService.getItemsByWarehouseName(name);

        //then
        Assertions.assertEquals(1, lista.size() );
    }

    @Test
    public void testGetItemsByWarehouseIdShouldReturnItemsByWarehouseId() {
        //given
        Long warehouseId = 1L;
        Raktar raktar = new Raktar(
                1L,"nev","varos","cim",15, List.of(
                new Alkatresz("cikkszam","megnevezes","tipus",1500)
        )
        );
        Mockito.when(raktarRepository.findById(warehouseId)).thenReturn(Optional.of(raktar));

        //when
        RaktarWithItemsDTO raktarWithItemsDTO = raktarService.getItemsByWarehouseId(warehouseId);

        //then
        Assertions.assertEquals(raktarWithItemsDTO.getId(), raktar.getId());
        Assertions.assertEquals(raktarWithItemsDTO.getNev(), raktar.getNev());
        Assertions.assertEquals(raktarWithItemsDTO.getVaros(), raktar.getVaros());
        Assertions.assertEquals(raktarWithItemsDTO.getCim(), raktar.getCim());
        Assertions.assertEquals(raktarWithItemsDTO.getKapacitas(), raktar.getKapacitas());
        Assertions.assertEquals(raktarWithItemsDTO.getAlkatreszek().size(), raktar.getAlkatreszek().size());

    }

    @Test
    public void testConvertToRaktarWithItemsDTOShouldConvertToRaktarWithItemsDTO() {
        //given

        Alkatresz alkatresz = new Alkatresz(
          "cikkszam","megnevezes","autotipus",1000
        );

        Raktar raktar = new Raktar(
                1L,"nev","varos","cim",15, List.of(alkatresz)
        );

        //when
        RaktarWithItemsDTO raktarWithItemsDTO  = raktarService.convertToRaktarWithItemsDTO(raktar);

        //then
        Assertions.assertEquals(raktarWithItemsDTO.getAlkatreszek().size(), raktar.getAlkatreszek().size());
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
