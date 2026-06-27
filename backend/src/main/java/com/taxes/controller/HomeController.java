package com.taxes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return """
            <!DOCTYPE html>
            <html lang="fr">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Plateforme de Gestion des Taxes Locatives</title>
                <style>
                    * {
                        margin: 0;
                        padding: 0;
                        box-sizing: border-box;
                    }
                    
                    body {
                        font-family: 'Segoe UI', -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Arial, sans-serif;
                        min-height: 100vh;
                        display: flex;
                        justify-content: center;
                        align-items: center;
                        padding: 20px;
                        background: linear-gradient(135deg, #0a1628 0%, #1a2a4a 30%, #1a237e 60%, #0d47a1 100%);
                        background-attachment: fixed;
                        position: relative;
                    }
                    
                    body::before {
                        content: '';
                        position: absolute;
                        top: 0;
                        left: 0;
                        right: 0;
                        bottom: 0;
                        background-image: 
                            radial-gradient(2px 2px at 20px 30px, rgba(255,255,255,0.3), transparent),
                            radial-gradient(2px 2px at 40px 70px, rgba(255,255,255,0.2), transparent),
                            radial-gradient(2px 2px at 50px 160px, rgba(255,255,255,0.3), transparent),
                            radial-gradient(2px 2px at 90px 40px, rgba(255,255,255,0.2), transparent),
                            radial-gradient(2px 2px at 130px 80px, rgba(255,255,255,0.3), transparent),
                            radial-gradient(2px 2px at 160px 30px, rgba(255,255,255,0.2), transparent);
                        background-size: 200px 200px;
                        pointer-events: none;
                        z-index: 0;
                    }
                    
                    .container {
                        position: relative;
                        z-index: 1;
                        max-width: 900px;
                        width: 100%;
                        background: rgba(255, 255, 255, 0.95);
                        backdrop-filter: blur(20px);
                        border-radius: 24px;
                        padding: 60px 50px;
                        box-shadow: 0 40px 80px rgba(0,0,0,0.6), 0 10px 30px rgba(0,0,0,0.3);
                        animation: fadeUp 0.8s ease;
                        border: 1px solid rgba(255,255,255,0.1);
                    }
                    
                    @keyframes fadeUp {
                        from { opacity: 0; transform: translateY(30px); }
                        to { opacity: 1; transform: translateY(0); }
                    }
                    
                    .header {
                        text-align: center;
                        margin-bottom: 40px;
                    }
                    
                    .logo-wrapper {
                        display: inline-flex;
                        align-items: center;
                        justify-content: center;
                        background: linear-gradient(135deg, #1a237e, #1976d2);
                        width: 80px;
                        height: 80px;
                        border-radius: 20px;
                        margin-bottom: 20px;
                        box-shadow: 0 10px 30px rgba(26, 35, 126, 0.3);
                    }
                    
                    .logo-wrapper span {
                        font-size: 40px;
                    }
                    
                    .header h1 {
                        font-size: 36px;
                        font-weight: 700;
                        color: #1a237e;
                        letter-spacing: -0.5px;
                        margin-bottom: 8px;
                    }
                    
                    .header .subtitle {
                        font-size: 18px;
                        color: #666;
                        font-weight: 400;
                    }
                    
                    .header .subtitle span {
                        color: #1a237e;
                        font-weight: 500;
                    }
                    
                    .divider {
                        width: 60px;
                        height: 4px;
                        background: linear-gradient(to right, #1a237e, #1976d2);
                        margin: 20px auto 0;
                        border-radius: 4px;
                    }
                    
                    .status-bar {
                        display: flex;
                        justify-content: center;
                        gap: 30px;
                        flex-wrap: wrap;
                        background: #f0f4f8;
                        border-radius: 16px;
                        padding: 18px 30px;
                        margin: 30px 0 35px;
                    }
                    
                    .status-item {
                        display: flex;
                        align-items: center;
                        gap: 10px;
                        color: #444;
                        font-size: 14px;
                        font-weight: 500;
                    }
                    
                    .status-item .dot {
                        width: 10px;
                        height: 10px;
                        border-radius: 50%;
                        display: inline-block;
                        animation: pulse 2s ease-in-out infinite;
                    }
                    
                    .status-item .dot.green { background: #4caf50; }
                    .status-item .dot.blue { background: #1976d2; }
                    .status-item .dot.orange { background: #ff9800; }
                    
                    @keyframes pulse {
                        0%, 100% { opacity: 1; transform: scale(1); }
                        50% { opacity: 0.6; transform: scale(0.9); }
                    }
                    
                    .features {
                        display: grid;
                        grid-template-columns: repeat(3, 1fr);
                        gap: 20px;
                        margin-bottom: 35px;
                    }
                    
                    .feature-card {
                        background: #f8fafc;
                        border-radius: 16px;
                        padding: 30px 20px;
                        text-align: center;
                        transition: all 0.3s ease;
                        border: 1px solid #eef2f6;
                    }
                    
                    .feature-card:hover {
                        transform: translateY(-6px);
                        box-shadow: 0 12px 30px rgba(26, 35, 126, 0.12);
                        border-color: #1a237e;
                    }
                    
                    .feature-card .icon {
                        font-size: 36px;
                        margin-bottom: 12px;
                    }
                    
                    .feature-card h3 {
                        font-size: 16px;
                        font-weight: 600;
                        color: #1a237e;
                        margin-bottom: 6px;
                    }
                    
                    .feature-card p {
                        font-size: 14px;
                        color: #888;
                        line-height: 1.5;
                    }
                    
                    .cta-section {
                        display: flex;
                        justify-content: center;
                        gap: 16px;
                        flex-wrap: wrap;
                        margin: 10px 0 30px;
                    }
                    
                    .btn {
                        display: inline-flex;
                        align-items: center;
                        gap: 10px;
                        padding: 14px 32px;
                        border-radius: 12px;
                        font-size: 15px;
                        font-weight: 600;
                        text-decoration: none;
                        transition: all 0.3s ease;
                        border: none;
                        cursor: pointer;
                    }
                    
                    .btn-primary {
                        background: linear-gradient(135deg, #1a237e, #1976d2);
                        color: white;
                        box-shadow: 0 4px 15px rgba(26, 35, 126, 0.25);
                    }
                    
                    .btn-primary:hover {
                        transform: translateY(-2px);
                        box-shadow: 0 8px 30px rgba(26, 35, 126, 0.35);
                    }
                    
                    .btn-secondary {
                        background: white;
                        color: #1a237e;
                        border: 2px solid #1a237e;
                    }
                    
                    .btn-secondary:hover {
                        background: #f0f4ff;
                        transform: translateY(-2px);
                        box-shadow: 0 8px 25px rgba(26, 35, 126, 0.15);
                    }
                    
                    .footer {
                        text-align: center;
                        padding-top: 25px;
                        border-top: 1px solid #eef2f6;
                        margin-top: 10px;
                    }
                    
                    .footer .brand {
                        font-size: 14px;
                        color: #1a237e;
                        font-weight: 600;
                    }
                    
                    .footer .brand span {
                        color: #1976d2;
                    }
                    
                    .footer .version {
                        font-size: 12px;
                        color: #aaa;
                        margin-top: 4px;
                    }
                    
                    .footer .version span {
                        background: #f0f4f8;
                        padding: 2px 12px;
                        border-radius: 20px;
                    }
                    
                    .footer .links {
                        margin-top: 12px;
                        display: flex;
                        justify-content: center;
                        gap: 20px;
                        flex-wrap: wrap;
                    }
                    
                    .footer .links a {
                        color: #888;
                        text-decoration: none;
                        font-size: 13px;
                        transition: color 0.3s;
                    }
                    
                    .footer .links a:hover {
                        color: #1a237e;
                        text-decoration: underline;
                    }
                    
                    .welcome-message {
                        text-align: center;
                        padding: 15px 20px;
                        background: linear-gradient(135deg, #e3f2fd, #bbdefb);
                        border-radius: 12px;
                        margin: 10px 0 25px;
                        border-left: 4px solid #1a237e;
                    }
                    
                    .welcome-message p {
                        color: #1a237e;
                        font-size: 16px;
                        font-weight: 500;
                    }
                    
                    @media (max-width: 768px) {
                        .container { padding: 35px 25px; }
                        .header h1 { font-size: 26px; }
                        .features { grid-template-columns: 1fr; }
                        .status-bar { flex-direction: column; align-items: center; gap: 12px; }
                        .cta-section { flex-direction: column; align-items: center; }
                        .btn { width: 100%; justify-content: center; }
                        .logo-wrapper { width: 60px; height: 60px; }
                        .logo-wrapper span { font-size: 30px; }
                        .welcome-message p { font-size: 14px; }
                    }
                    
                    @media (max-width: 480px) {
                        .container { padding: 25px 18px; border-radius: 16px; }
                        .header h1 { font-size: 22px; }
                    }
                </style>
            </head>
            <body>
                <div class="container">
                    <div class="header">
                        <div class="logo-wrapper">
                            <span>🏛️</span>
                        </div>
                        <h1>Plateforme Taxes Locatives</h1>
                        <p class="subtitle">Gestion dématérialisée des taxes <span>TIB</span> &amp; <span>TNB</span></p>
                        <div class="divider"></div>
                    </div>
                    
                    <div class="welcome-message">
                        <p>👋 Bienvenue sur la Plateforme de Gestion des Taxes Locatives</p>
                    </div>
                    
                    <div class="status-bar">
                        <div class="status-item">
                            <span class="dot green"></span>
                            Système opérationnel
                        </div>
                        <div class="status-item">
                            <span class="dot blue"></span>
                            Version 1.0.0
                        </div>
                        <div class="status-item">
                            <span class="dot orange"></span>
                            CNI - Centre National d'Informatique
                        </div>
                    </div>
                    
                    <div class="features">
                        <div class="feature-card">
                            <div class="icon">🏠</div>
                            <h3>Gestion des Biens</h3>
                            <p>Enregistrement et suivi des maisons (TIB) et terrains (TNB)</p>
                        </div>
                        <div class="feature-card">
                            <div class="icon">📊</div>
                            <h3>Calcul Automatique</h3>
                            <p>Calcul des taxes selon les paramètres configurés</p>
                        </div>
                        <div class="feature-card">
                            <div class="icon">📨</div>
                            <h3>Gestion des Avis</h3>
                            <p>Génération et envoi des avis de paiement</p>
                        </div>
                    </div>
                    
                    <div class="cta-section">
                        <a href="http://localhost:8080/swagger-ui.html" class="btn btn-primary">
                            📚 Documentation API
                        </a>
                    </div>
                    
                    <div class="footer">
                        <div class="brand">🏛️ <span>Plateforme Taxes Locatives</span></div>
                        <div class="version"><span>v1.0.0</span></div>
                        <div class="links">
                            <a href="http://localhost:8080">Accueil</a>
                            <a href="http://localhost:8080/swagger-ui.html">API Docs</a>
                            <a href="http://localhost:8080/actuator/health">Health</a>
                        </div>
                    </div>
                </div>
            </body>
            </html>
            """;
    }
}