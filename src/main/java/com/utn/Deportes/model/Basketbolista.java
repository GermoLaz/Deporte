package com.utn.Deportes.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonTypeName("basketbolista")
@EqualsAndHashCode(callSuper = true)
@Entity
public class Basketbolista extends Deportista{
    private Integer puntos;
    private Integer rebotes;
}
