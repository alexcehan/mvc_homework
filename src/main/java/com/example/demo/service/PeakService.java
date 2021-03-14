package com.example.demo.service;


import com.example.demo.dto.PeakCreationRequest;
import com.example.demo.dto.PeakUpdateRequest;
import com.example.demo.entity.PeakEntity;
import com.example.demo.exception.PeakNotFoundException;
import com.example.demo.repository.PeakRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@AllArgsConstructor
public class PeakService {

    private final PeakRepository peakRepository;

    public List<PeakEntity> getAllPeaks() {
        return peakRepository.findAll();
    }


    public PeakEntity getPeakById(Integer id) {
        return peakRepository.findById(id).orElseThrow(() ->new PeakNotFoundException("No peak found for this id!"));


    }

    public PeakEntity updatePeak(PeakUpdateRequest request) {
        PeakEntity peakEntity = peakRepository.findById(request.getId()).orElseThrow(() -> new PeakNotFoundException("No peak found for this id!"));

        peakEntity.setId(request.getId());
        peakEntity.setName(request.getName());
        peakEntity.setHeight(request.getHeight());
        peakEntity.setMountain_range(request.getMountain_range());
        peakEntity.setCounty(request.getCounty());

        return peakRepository.save(peakEntity);
    }

    public PeakEntity createPeak (PeakCreationRequest request) {
        var peakEntityBuilder = PeakEntity.builder()
                .id(request.getId())
                .name(request.getName())
                .height(request.getHeight())
                .mountain_range(request.getMountain_range())
                .county(request.getCounty())
                .build();


        return peakRepository.save(peakEntityBuilder);


    }

    public void deletePeakById(Integer id) {
        peakRepository.deleteById(id);
    }



}
