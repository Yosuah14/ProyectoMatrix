CREATE OR REPLACE PROCEDURE insertar_centros (
    v_cod_centro  IN ce_centros.cod_centro%TYPE,
    v_tipo_centro IN ce_centros.tipo_centro%type,
    v_nombre      IN ce_centros.nombre%TYPE,
    v_direccion   IN ce_centros.direccion%TYPE,
    v_telefono    IN ce_centros.telefono%TYPE,
    v_num_plazas  IN ce_centros.num_plazas%TYPE,
    v_booleans    OUT BOOLEAN default false
) AS
    existe BOOLEAN;
BEGIN
    existe_centro(v_cod_centro, existe);
    IF not existe THEN
        INSERT INTO ce_centros (
            cod_centro,
            tipo_centro,
            nombre,
            direccion,
            telefono,
            num_plazas
        ) VALUES (
            v_cod_centro,
            v_tipo_centro,
            v_nombre,
            v_direccion,
            v_telefono,
            v_num_plazas
        );

        v_booleans := true;
    ELSE
        v_booleans := false;
    END IF;

END;
/


declare 
exitoso BOOLEAN;
begin
    insertar_centros(6,'S', 'IES Antoñete', 'C/Los Toreros 21','989-406090',31,exitoso);
    IF exitoso THEN
        dbms_output.put_line('insertado');
    ELSE
        dbms_output.put_line('NO insertado');
    END IF;
end;
