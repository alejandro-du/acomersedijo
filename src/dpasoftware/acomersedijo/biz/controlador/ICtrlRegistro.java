package dpasoftware.acomersedijo.biz.controlador;

import dpasoftware.acomersedijo.accesoDatos.vo.Empresa;

/**
 * Proporciona funcionalidad para los VOs Anunciante.
 * @author Alejandro
 */
public interface ICtrlRegistro {
    
    String registrar(Empresa empresa);
    
    String confirmarRegistro(Long id, String codigo);
    
}
