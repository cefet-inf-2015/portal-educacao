<!-- Modal de login -->
<div id="modal1" class="modal modal-fixed-footer">
  <div class="modal-content">
    <h4>Login</h4>
    <div class="row">
      <p>Insira dados</p>
      <form>
        <label for="username">Nome de usuario</label>
        <input type="text" name="username">
        <label for="senha">Senha</label>
        <input type="password" name="senha">
        <label for="tipoUsuario">Tipo de usuário</label>
        <select name="tipoUsuario" id="tipoUsuario">
          <option value="" disabled selected>Tipo de Usuario</option>
          <option value="1">Aluno</option>
          <option value="2">Professor</option>
          <option value="3">Coordenador</option>
          <option value="4">Diretor</option>
        </select>
        <button class="col s12 btn-flat waves-effect waves-light green white-text" type="button" name="action" id="loginBtn">Entrar
            <i class="material-icons right">input</i>
          </button>
      </form>
      <div id="targetId" style="color: red;"></div>

    </div>
  </div>
  <div class="modal-footer">
    <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat red white-text">Sair</a>
  </div>
</div>