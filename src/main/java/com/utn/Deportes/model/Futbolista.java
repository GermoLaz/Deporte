package com.utn.Deportes.model;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonTypeName("futbolista")
@EqualsAndHashCode(callSuper = true)
@Entity
public class Futbolista extends Deportista{

    private Integer totalGoles;
    private Integer penal;
    private Integer cabeza;
    private Integer tiroLibre;
}
