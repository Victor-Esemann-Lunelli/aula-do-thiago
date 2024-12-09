package model;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.automovel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-12-09T18:23:25", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(revisao.class)
public class revisao_ { 

    public static volatile SingularAttribute<revisao, String> servicos_realizados;
    public static volatile SingularAttribute<revisao, Double> km;
    public static volatile SingularAttribute<revisao, Date> data;
    public static volatile SingularAttribute<revisao, automovel> automovel;
    public static volatile SingularAttribute<revisao, Integer> id;

}