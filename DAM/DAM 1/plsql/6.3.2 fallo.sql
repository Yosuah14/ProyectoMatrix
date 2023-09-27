CREATE OR REPLACE PROCEDURE existe_centro (
    v_codcentro IN ce_centros.cod_centro%TYPE,
    v_boolean OUT BOOLEAN
)
AS 
BEGIN 
  IF v_codcentro IN (SELECT cod_centro FROM ce_centros WHERE cod_centro = v_codcentro) THEN  
    v_boolean := true;
  ELSE 
    v_boolean := false;
  END IF;
END;
/ 