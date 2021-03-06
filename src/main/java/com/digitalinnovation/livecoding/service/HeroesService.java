package com.digitalinnovation.livecoding.service;


import com.digitalinnovation.livecoding.document.Heroes;
import com.digitalinnovation.livecoding.repository.HeroesRepository;
import com.digitalinnovation.livecoding.exceptions.*;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class HeroesService {
  private final HeroesRepository heroesRepository;

  public HeroesService(HeroesRepository heroesRepository) {
    this.heroesRepository = heroesRepository;
  }

  public Flux<Heroes> findAll(){

    return Flux.fromIterable(this.heroesRepository.findAll());
  }

  public  Mono<Heroes> findByIdHero(String id){
    return  Mono.justOrEmpty(this.heroesRepository.findById(id)).switchIfEmpty(Mono.error(new HeroNotFoundException(id)));
  }


  public Mono<Heroes> save(Heroes heroes){
    return  Mono.justOrEmpty(this.heroesRepository.save(heroes));
  }


  public Mono<Boolean> deletebyIDHero(String id) {
    heroesRepository.deleteById(id);
    return Mono.just(true);
  }

  public Mono<Heroes> verifyIfExists(String id){
    return findByIdHero(id).switchIfEmpty(Mono.error(new HeroNotFoundException(id)));
  }

  public Mono<Heroes> updateByIDHero(String id, Heroes heroes){

    if(!findByIdHero(id).equals(Mono.empty())){
      return Mono.just(this.heroesRepository.save(heroes));
    }
    return Mono.error(new HeroNotFoundException(id));

  }
}

