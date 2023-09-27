DECLARE
nombre depart.dnombre%type;
    suma  NUMBER;
    media NUMBER;
    nombredep depart.dnombre%TYPE:='%&departamento%';
BEGIN
    SELECT
    DNOMBRE,
        SUM(salario),
        AVG(salario)
    INTO
        suma,
        media
    FROM
             emple e
        INNER JOIN depart d ON ( e.dept_no = d.dept_no )
    WHERE
        upper(dnombre) = UPPER(nombredep);
    if nombredep NOT IN(,,,,)< 'CONTABILIDAD' OR nombredep <> 'CONTABILIDAD'OR nombredep <> 'CONTABILIDAD'OR  then
    DBMS_OUTPUT.PUT_LINE('El departamento no existe');
    else 
    DBMS_OUTPUT.PUT_LINE('SUMA DE SALARIOS DE '||nombredep||' '||suma);
    DBMS_OUTPUT.PUT_LINE('MEDIA DE SALARIOS DE '||nombredep||' '||media);
    end if;
END;
/