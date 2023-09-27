DECLARE
V_APELLIDO VARCHAR2(40);
V_SALARIO EMPLE.SALARIO%TYPE;
V_EMPLE EMPLE%ROWTYPE;
BEGIN
SELECT APELLIDO, SALARIO INTO V_APELLIDO, V_SALARIO
FROM EMPLE WHERE EMP_NO=7900;
DBMS_OUTPUT.PUT_LINE('APELLIDO : '||V_APELLIDO
||' SALARIO:'||V_SALARIO);
SELECT * INTO V_EMPLE
FROM EMPLE WHERE EMP_NO=7900;
DBMS_OUTPUT.PUT_LINE('APELLIDO : '||V_EMPLE.APELLIDO
||' OFICIO:'||V_EMPLE.OFICIO);
END;