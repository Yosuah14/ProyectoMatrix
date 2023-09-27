CREATE OR REPLACE FUNCTION total_modelo (
    anio      NUMBER,
    id_modelo S_VEHICULOS.MODELO%TYPE
) RETURN NUMBER IS
    num_accidentes NUMBER;
BEGIN
    SELECT
        COUNT(*)
    INTO num_accidentes
    FROM
             s_vehic_accid a
        INNER JOIN s_vehiculos v ON ( a.matricula = v.matricula )
    WHERE
           modelo = upper(id_modelo)
        AND EXTRACT(YEAR FROM fecha_accidente) = anio;

    RETURN num_accidentes;
END;
/


declare 
anio    NUMBER :=&año;
id_modelo S_VEHICULOS.MODELO%TYPE:= '&modelocoche';
num_accidentes NUMBER;
begin
num_accidentes:=total_modelo(anio,id_modelo);
dbms_output.put_line('El numero de accidentes es '||num_accidentes);
end;
/