CREATE OR REPLACE PROCEDURE nasa (
    tipo     IN VARCHAR2,
    ordenado IN NUMBER
    
) AS
    --contador NUMBER DEFAULT 0;
    CURSOR c1 IS
    SELECT
        *
    FROM
        objeto_estelar
     WHERE UPPER(TRIM(clase)) = UPPER(TRIM(tipo))
    ORDER BY
        redshift asc;

    CURSOR c2 IS
    SELECT
        *
    FROM
        objeto_estelar
    WHERE UPPER(TRIM(clase)) = UPPER(TRIM(tipo))
    ORDER BY
        redshift desc;

    CURSOR c3 IS
    SELECT
        *
    FROM
        objeto_estelar
     WHERE UPPER(TRIM(clase)) = UPPER(TRIM(tipo));
        
    
BEGIN

    IF tipo is null or upper(tipo) not in ('GALAXIA','ESTRELLA','QUASAR') THEN
        dbms_output.put_line('el tipo indicado no existe entre nuestros datos ');
    ELSE
        IF ordenado = 1 THEN
            FOR fila IN c1 LOOP
                dbms_output.put_line('el objeto '
                                     || tipo
                                     || ' con identificador'
                                     || fila.obj_id
                                     || ' tiene un valor redshift= '
                                     || fila.redshift
                                     || ' alpha='
                                     || fila.alpha
                                     || ' delta='
                                     || fila.delta);
            END LOOP;
        ELSIF ordenado = -1 THEN
            FOR fila IN c2 LOOP
                dbms_output.put_line('el objeto '
                                     || tipo
                                     || ' con identificador
            '
                                     || fila.obj_id
                                     || ' tiene un valor redshift= '
                                     || fila.redshift
                                     || ' alpha='
                                     || fila.alpha
                                     || ' delta='
                                     || fila.delta);
            END LOOP;
        ELSE
            FOR fila IN c3 LOOP
                dbms_output.put_line('el objeto '
                                     || tipo
                                     || ' con identificador
            '
                                     || fila.obj_id
                                     || ' tiene un valor redshift= '
                                     || fila.redshift
                                     || ' alpha='
                                     || fila.alpha
                                     || ' delta='
                                     || fila.delta);
            END LOOP;
        END IF;
    END IF;
END;
/


BEGIN
    nasa('quasar', 1);
END;
/
