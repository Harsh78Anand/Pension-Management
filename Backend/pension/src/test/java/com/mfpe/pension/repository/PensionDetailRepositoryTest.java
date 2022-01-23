package com.mfpe.pension.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.Rollback;

import com.mfpe.pension.model.PensionDetail;

@RunWith(MockitoJUnitRunner.class) 

public class PensionDetailRepositoryTest {



	@Mock
	private PensionDetailRepository pensionDetailRepository;
	
	private PensionDetail pensionDetail;
	@BeforeAll
	@Rollback(value = false)
	public void setUp() {
		
		
	}
	
	@Test
	public void findPensionDetail() {
		LocalDate date = LocalDate.of(1997, 10, 12);
		pensionDetail = new PensionDetail("xyz2323", "John", date, 15000, true);
		Optional <PensionDetail> pdo = Optional.of(pensionDetail);
		when(pensionDetailRepository.findById("xyz2323")).thenReturn(pdo);
		when(pensionDetailRepository.save(pensionDetail)).thenReturn(pensionDetail);
		pensionDetailRepository.save(pensionDetail);
		
		
		Optional<PensionDetail> pd = pensionDetailRepository.findById("xyz2323");
		assertEquals(pensionDetail.getName(), pd.get().getName() );
	}
	@Test
	public void findPensionDetailNotFound() {
		LocalDate date = LocalDate.of(1997, 10, 12);
		pensionDetail = new PensionDetail("xyz2323", "John", date, 15000, true);
		Optional <PensionDetail> pdo = Optional.of(pensionDetail);
		
		when(pensionDetailRepository.save(pensionDetail)).thenReturn(pensionDetail);
		pensionDetailRepository.save(pensionDetail);
		
		
		Optional<PensionDetail> pd = pensionDetailRepository.findById("x2323");
		assertTrue(pd.isEmpty());
	}
}
