package com.sp.service;

import com.sp.config.ApplicationConfig;
import com.sp.entities.AddressEntity;
import com.sp.entities.MerchantEntity;
import com.sp.utilis.ListUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class}, loader = AnnotationConfigContextLoader.class)
public class MerchantServiceTest {

    @Autowired
    private IMerchantService merchantService;

    private static MerchantEntity merchantEntity;

    @BeforeClass
    public static void setUp() throws ParseException {
        merchantEntity = new MerchantEntity();
        merchantEntity.setName("wissam");
        merchantEntity.setLastName("berkati");
        merchantEntity.setBirthDate(new SimpleDateFormat("yyyy-MM-dd").parse("1993-04-22"));

        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setStreet("italie morrooo");
        addressEntity.setNumber(888);
        addressEntity.setZipCode("1665");
        merchantEntity.addAddress(addressEntity);
    }

    @Test
    @Transactional
    public void createMerchant() {
        Integer id = merchantService.create(merchantEntity);
        Optional<MerchantEntity> existedMerchantOptional = merchantService.findById(id);
        assertTrue(existedMerchantOptional.isPresent());
        MerchantEntity existedMerchant = existedMerchantOptional.get();

        assertEquals(existedMerchant.getCreateDate().getTime(), merchantEntity.getCreateDate().getTime());
        assertEquals(existedMerchant.getLastName(), merchantEntity.getLastName());
        assertEquals(existedMerchant.getName(), merchantEntity.getName());
        assertEquals(existedMerchant.getBirthDate(), merchantEntity.getBirthDate());
        assertTrue(ListUtils.isNotEmpty(existedMerchant.getAddressList()));
        assertEquals(existedMerchant.getAddressList().size(), 1);

        merchantService.deleteById(id);
    }

    @Test
    @Transactional
    public void UpdateMerchant() {
        Integer id = merchantService.create(merchantEntity);
        Optional<MerchantEntity> existedMerchantOptional = merchantService.findById(id);
        assertTrue(existedMerchantOptional.isPresent());
        MerchantEntity existedMerchant = existedMerchantOptional.get();
        existedMerchant.setLastName("newLastName");
        existedMerchant.setName("newName");

        MerchantEntity updatedMerchant = merchantService.update(existedMerchant);
        assertEquals(updatedMerchant.getLastName(), existedMerchant.getLastName());
        assertEquals(updatedMerchant.getName(), existedMerchant.getName());
        merchantService.deleteById(id);
    }

    @Test
    public void deleteById() {
        Integer id = merchantService.create(merchantEntity);
        merchantService.deleteById(id);
        Optional<MerchantEntity> existedMerchantOptional = merchantService.findById(id);
        assertFalse(existedMerchantOptional.isPresent());
    }

    @Test
    public void findById() {
        Integer id = merchantService.create(merchantEntity);
        Optional<MerchantEntity> existedMerchantOptional = merchantService.findById(id);
        assertTrue(existedMerchantOptional.isPresent());
    }
}
