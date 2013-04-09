-- Tuple Compare Rule :: ${column1} ${column2} ${operand}
    BEGIN
        IF l_oper IN ('INS', 'UPD')
        THEN
            IF NOT :new.${column1} ${operand} :new.${column2}
            THEN 
                l_errors := l_errors || 'The value of ${column1} must be ${operand} ${column2}';
            END IF;
        END IF;
    END;