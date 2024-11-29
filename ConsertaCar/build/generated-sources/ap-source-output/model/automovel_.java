package model;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.cliente;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-11-29T10:39:50", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(automovel.class)
public class automovel_ { 

    public static volatile SingularAttribute<automovel, String> marca;
    public static volatile SingularAttribute<automovel, cliente> cliente;
    public static volatile SingularAttribute<automovel, Integer> ano;
    public static volatile SingularAttribute<automovel, Integer> id;
    public static volatile SingularAttribute<automovel, String> modelo;
    public static volatile SingularAttribute<automovel, String> placa;

}