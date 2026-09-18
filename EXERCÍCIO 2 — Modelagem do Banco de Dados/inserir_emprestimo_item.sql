INSERT INTO emprestimo (item_id, usuario_id, data_retirada, data_devolucao_prevista, data_devolucao, valor_multa) VALUES 
(1, 1, DATE '2026-07-10', DATE '2026-07-24', NULL, NULL),
(3, 2, DATE '2026-08-05', DATE '2026-08-12', DATE '2026-08-14', 2.00);

UPDATE item SET disponibilidade = FALSE WHERE id = 1;