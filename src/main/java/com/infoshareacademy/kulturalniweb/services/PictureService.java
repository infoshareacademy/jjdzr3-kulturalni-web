package com.infoshareacademy.kulturalniweb.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PictureService {
    List<String> pictures;

    public PictureService() {
        pictures = new ArrayList<>();

        pictures.add("images/img/events/artist-3480274_640.jpg");
        pictures.add("images/img/events/audience-868074_640.jpg");
        pictures.add("images/img/events/audience-945449_640.jpg");
        pictures.add("images/img/events/audience-1850119_640.jpg");
        pictures.add("images/img/events/audience-1867754_640.jpg");
        pictures.add("images/img/events/audio-2941753_640.jpg");
        pictures.add("images/img/events/concert-768722_640.jpg");
        pictures.add("images/img/events/concert-1209323_640.jpg");
        pictures.add("images/img/events/concert-1209323_640.jpg");
        pictures.add("images/img/events/concert-3387324_640.jpg");
        pictures.add("images/img/events/conductor-5157153_640.jpg");
        pictures.add("images/img/events/confetti-2571539_640.jpg");
        pictures.add("images/img/events/guitar-756326_640.jpg");
        pictures.add("images/img/events/man-1031087_640.jpg");
        pictures.add("images/img/events/music-3090204_640.jpg");
        pictures.add("images/img/events/piano-801707_640.jpg");
        pictures.add("images/img/events/saxophones-691224_640.jpg");
        pictures.add("images/img/events/stage-336695_640.jpg");
        pictures.add("images/img/events/stage-336695_640 (1).jpg");
        pictures.add("images/img/events/violins-1838390_640.jpg");
    }

    public String getPictureFilename() {
        Random random = new Random();
        Integer i = random.nextInt(20);

        return pictures.get(i);
    }


}
